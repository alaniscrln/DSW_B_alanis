<?php

namespace App\Controller;

use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Annotation\Route;
use App\Entity\Persona;
use App\Form\PersonaType;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\Security\Core\Encoder\UserPasswordEncoderInterface;


class PersonaController extends AbstractController
{
    /**
     * @Route("/crear-usuario", name="crear_persona")
     */
    public function index(Request $request, UserPasswordEncoderInterface $passwordEncoder): Response
    {
        $persona = new Persona();
        $form = $this->createForm(PersonaType::class, $persona);
        $form->handleRequest($request);

        if($form->isSubmitted() && $form->isValid()){
            $em = $this->getDoctrine()->getManager();
            $persona->setPassword($passwordEncoder->encodePassword(
                $persona,
                $form['password']->getData()
            ));

            $em->persist($persona);
            $em->flush();
            return $this->redirectToRoute("app_login");
        }

        return $this->render('persona/index.html.twig', [
            'formulario' => $form->createView()
        ]);
    }
}
