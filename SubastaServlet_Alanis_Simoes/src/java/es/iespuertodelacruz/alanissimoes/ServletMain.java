/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespuertodelacruz.alanissimoes;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Alanis
 */
public class ServletMain extends HttpServlet {

    ArrayList<Usuario> usuarios = new ArrayList<>();
    Hashtable<String, ObjetoSubasta> articulos = new Hashtable<>();

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        response.setHeader("Refresh", "5");

        String login = request.getParameter("login");
        String password = request.getParameter("password");

        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ServletMain</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<a href=\"/SubastaServlet_Alanis_Simoes/vender\">"
                    + "Vender un articulo</a>");
            out.println("<a href=\"/SubastaServlet_Alanis_Simoes/login\">"
                    + "Salir</a>");

            Enumeration elem = articulos.elements();
            while (elem.hasMoreElements()) {
                ObjetoSubasta os = (ObjetoSubasta) (elem.nextElement());
                if (os.getPropietario().equals(login)) {
                    out.println("<br><a href=\"/SubastaServlet_Alanis_Simoes/main?"
                            + "accion=adjudicar&producto="
                            + os.getProducto() + "\">Adjudicar</a> "
                            + "<a href=\"/SubastaServlet_Alanis_Simoes/main?"
                            + "accion=cancelar&producto="
                            + os.getProducto() + "\">Cancelar</a> "
                            + os.getProducto() + " (" + os.getValor()
                            + ") [" + os.getUsuario() + "] ");
                }
            }

            elem = articulos.elements();
            while (elem.hasMoreElements()) {
                ObjetoSubasta os = (ObjetoSubasta) (elem.nextElement());
                if (!os.getPropietario().equals(login)) {
                    out.println("<br><a href=\"/subasta/comprar?producto="
                            + os.getProducto()
                            + "\">Comprar</a> "
                            + os.getProducto() + " (" + os.getValor()
                            + ") [" + os.getUsuario() + "] "
                    );
                }
            }

            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String accion = request.getParameter("accion");

        if (login == null || password == null || accion == null) {
            response.sendRedirect("/SubastaServlet_Alanis_Simoes/login");
        } else {

            switch (accion) {
                case "registrar":
                    String email = request.getParameter("email");
                    if (registraUsuario(login, password, email)) {
                        response.sendRedirect("/SubastaServlet_Alanis_Simoes/login");
                    } else {
                        response.sendRedirect("/SubastaServlet_Alanis_Simoes/registro");
                    }
                    break;
                case "validar":
                    if (!validaUsuario(login, password)) {
                        response.sendRedirect("/SubastaServlet_Alanis_Simoes/login");
                    }else{
                        //response.sendRedirect("/SubastaServlet_Alanis_Simoes/main");
                        processRequest(request, response);
                    }
                    break;
                case "comprar": {
                    String producto = request.getParameter("producto");
                    double valor = Double.parseDouble(request.getParameter("valor"));
                    ObjetoSubasta obj = (ObjetoSubasta) articulos.get(producto);
                    if (obj.getValor() < valor) {
                        obj.setPuja(login, valor);
                        articulos.put(producto, obj);
                    }
                    response.sendRedirect("/SubastaServlet_Alanis_Simoes/main?accion=validar");
                    break;
                }
                case "vender": {
                    String producto = request.getParameter("producto");
                    double valor = Double.parseDouble(request.getParameter("valor"));
                    articulos.put(producto, new ObjetoSubasta(producto, valor, login));
                    response.sendRedirect("/SubastaServlet_Alanis_Simoes/main?accion=validar");
                    break;
                }
                case "adjudicar": {
                    String producto = request.getParameter("producto");
                    articulos.remove(producto);
                    response.sendRedirect("/SubastaServlet_Alanis_Simoes/main?accion=validar");
                    break;
                }
                case "cancelar": {
                    String producto = request.getParameter("producto");
                    articulos.remove(producto);
                    response.sendRedirect("/SubastaServlet_Alanis_Simoes/main?accion=validar");
                    break;
                }
                default:
                    break;
            }
        }

    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    public class Usuario {

        private String login;
        private String password;
        private String email;

//--------------------------------------------------------------------------
        public Usuario(String login, String password, String email) {
            this.login = login;
            this.password = password;
            this.email = email;
        }

        public String getLogin() {
            return login;
        }

        public void setLogin(String login) {
            this.login = login;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

    }

    public boolean validaUsuario(String login, String password) {
        if (buscaUsuario(login) != null) {  // usuario encontrado
            Usuario usuario = buscaUsuario(login);
            if (usuario.getPassword().equals(password)) {
                return true;
            }
        }
        // usuario no encontrado / contraseña erronea
        return false;
    }

    public boolean registraUsuario(String login, String password, String email) {

        if (buscaUsuario(login) == null) {
            Usuario usuario = new Usuario(login, password, email);
            usuarios.add(usuario);
            return true;
        }
        return false; // no pudo registrar usuario
    }

    public Usuario buscaUsuario(String login) {
        for (Usuario usuario : usuarios) {
            if (usuario.getLogin().equals(login)) {
                return usuario;
            }

        }
        return null;
    }

    public class ObjetoSubasta {

        private String producto;
        private double valor;
        private String usuario;
        private String propietario;

        //----------------------------------------------------------------------------------
        public ObjetoSubasta(String producto, double valor, String usuario, String propietario) {
            this.producto = producto;
            this.valor = valor;
            this.usuario = usuario;
            this.propietario = propietario;
        }

        public ObjetoSubasta(String producto, double valor, String propietario) {
            this.producto = producto;
            this.valor = valor;
            this.propietario = propietario;
        }

        public String getProducto() {
            return producto;
        }

        public void setProducto(String producto) {
            this.producto = producto;
        }

        public double getValor() {
            return valor;
        }

        public void setValor(double valor) {
            this.valor = valor;
        }

        public String getUsuario() {
            return usuario;
        }

        public void setUsuario(String usuario) {
            this.usuario = usuario;
        }

        public String getPropietario() {
            return propietario;
        }

        public void setPropietario(String propietario) {
            this.propietario = propietario;
        }

        //----------------------------------------------------------------------------------
        public void setPuja(String usuario, double valor) {
            setUsuario(usuario);
            setValor(valor);
        }

    }
}
