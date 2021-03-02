<?php

namespace App\Entity;

use App\Repository\MascotaRepository;
use Doctrine\ORM\Mapping as ORM;

/**
 * @ORM\Entity(repositoryClass=MascotaRepository::class)
 */
class Mascota
{

    public function __construct(){
        $this->nombre = "";
        $this->raza = "";
    }

    /**
     * @ORM\ManyToOne(targetEntity="App\Entity\Persona", inversedBy="mascotas")
     */
    private $propietario;


    /**
     * @ORM\Id
     * @ORM\GeneratedValue
     * @ORM\Column(type="integer")
     */
    private $id;

    /**
     * @ORM\Column(type="string", length=50)
     */
    private $nombre;

    /**
     * @ORM\Column(type="string", length=255)
     */
    private $raza;


    public function getId(): ?int
    {
        return $this->id;
    }

    public function getNombre(): ?string
    {
        return $this->nombre;
    }

    public function setNombre(string $nombre): self
    {
        $this->nombre = $nombre;

        return $this;
    }

    public function getRaza(): ?string
    {
        return $this->raza;
    }

    public function setRaza(string $raza): self
    {
        $this->raza = $raza;

        return $this;
    }

    public function getPropietario()
    {
        return $this->propietario;
    }

    public function setPropietario($propietario)
    {
        $this->propietario = $propietario;

    }


}
