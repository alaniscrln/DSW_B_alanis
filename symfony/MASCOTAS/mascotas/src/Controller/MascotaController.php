<?php

namespace App\Controller;

use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Annotation\Route;
use App\Entity\Mascota;
use App\Form\MascotaType;
use Symfony\Component\HttpFoundation\Request;

class MascotaController extends AbstractController
{
    /**
     * @Route("/guardar/mascota", name="guardar-mascota")
     */
    public function index(Request $request): Response
    {

        $mascota = new Mascota();
        $form = $this->createForm(MascotaType::class, $mascota);
        $form->handleRequest($request);
        
        if($form->isSubmitted() && $form->isValid()){
            $persona = $this->getUser();
            $mascota->setPropietario($persona);
            $em = $this->getDoctrine()->getManager();
            $em->persist($mascota);
            $em->flush();
            return $this->redirectToRoute("dashboard");
        }

        return $this->render('mascota/index.html.twig', [
            'formulario' => $form->createView(),
            'persona' => $this->getUser()
        ]);
    }

    /**
     * @Route("/mascota/{id}", name="ver-mascota")
     */
    public function verMascota($id){
        $em = $this->getDoctrine()->getManager();
        $mascota = $em->getRepository( Mascota::class)->find($id);
        return $this->render('mascota/verMascota.html.twig', [
            'mascota' => $mascota
        ]);
    }
}
