<?php

namespace App\Controller;

use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Annotation\Route;
use App\Entity\Mascota;

class DashboardController extends AbstractController
{
    /**
     * @Route("/", name="dashboard")
     */
    public function index(): Response
    {
        $user = $this->getUser();

        if($user){
            $em = $this->getDoctrine()->getManager();
            $mascotas = $em->getRepository(Mascota::class)->findBy(['propietario'=>$user]); 
    
    
            return $this->render('dashboard/index.html.twig', [
                'mascotas' => $mascotas,
                'user' => $user->getUsername()
            ]);
        }else{
            return $this->redirectToRoute('crear_persona');
        }

        
    }
}
