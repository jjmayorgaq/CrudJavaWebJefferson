package Controllers;

import Models.data.CategoriesDAO_JDBC;
import Models.data.ProductsDAO_JDBC;
import Models.domain.CategoriesDTO;
import Models.domain.ProductsDTO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.RequestDispatcher;

@WebServlet(name = "Product")
public class ControllerProduct extends HttpServlet {
    
    ProductsDAO_JDBC productsDAO_JDBC = new ProductsDAO_JDBC();
    CategoriesDAO_JDBC categoriesDAO_JDBC = new CategoriesDAO_JDBC();
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String action = request.getParameter("action");
        try {
                switch (action) {
                case "list":
                        list(request, response);
                        break;
                case "addView":
                        addView(request, response);
                        break;
                case "addProduct":
                        addProduct(request, response);
                        break; 
                case "editView":
                        editView(request, response);
                        break;
                case "editProduct":
                        editProduct(request, response);
                        break;
                case "delete":
                        delete(request, response);
                        break;
                default:
                        break;
                }			
        } catch (SQLException e) {
                e.getStackTrace();
        }
    }
    
    private void list(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException , ServletException{
		
        RequestDispatcher dispatcher = request.getRequestDispatcher("/views/Products.jsp");
        List<ProductsDTO> products = productsDAO_JDBC.select();
        request.setAttribute("productsList", products);
        dispatcher.forward(request, response);
    }
    
    private void addView(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException , ServletException{
		
        RequestDispatcher dispatcher = request.getRequestDispatcher("/views/Products.jsp");
        List<CategoriesDTO> categories = categoriesDAO_JDBC.select();
        request.setAttribute("categories", categories);
        dispatcher.forward(request, response);
    }
    
     private void addProduct(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException , ServletException{
		
        boolean isProductSuccess = false;
        ProductsDTO product = new ProductsDTO();
        product.setName(request.getParameter("name"));
        product.setPrice(request.getParameter("price"));
        product.setStock(request.getParameter("stock"));
        product.setIdCategory(request.getParameter("idCategory"));
        
        isProductSuccess = productsDAO_JDBC.insert(product);
        
        if (isProductSuccess) {

            response.sendRedirect("/CrudJavaWebJefferson/products?action=list&isProductSuccess=true");
            
        } else {

            response.sendRedirect("/CrudJavaWebJefferson/products?action=list&isProductSuccess=false");
        }
    }
     
    private void editView(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException , ServletException{
		
        RequestDispatcher dispatcher = request.getRequestDispatcher("/views/Products.jsp");
        List<CategoriesDTO> categories = categoriesDAO_JDBC.select();
        request.setAttribute("categories", categories);
        
        request.setAttribute("product", productsDAO_JDBC.getById(Integer.parseInt(request.getParameter("id"))));
        dispatcher.forward(request, response);
    }
    
    private void editProduct(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException , ServletException{
		
        boolean isProductSuccess = false;
        ProductsDTO product = new ProductsDTO();
        product.setIdProduct(Integer.parseInt(request.getParameter("id")));
        product.setName(request.getParameter("name"));
        product.setPrice(request.getParameter("price"));
        product.setStock(request.getParameter("stock"));
        product.setIdCategory(request.getParameter("idCategory"));
        
        isProductSuccess = productsDAO_JDBC.update(product);
        
        if (isProductSuccess) {

            response.sendRedirect("/CrudJavaWebJefferson/products?action=list&isProductEditSuccess=true");
        } else {

            response.sendRedirect("/CrudJavaWebJefferson/products?action=list&isProductSuccess=false");
        }
    }
    
    private void delete(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException , ServletException{
		
        boolean isProductDeleteSuccess = false;
        isProductDeleteSuccess = productsDAO_JDBC.delete(Integer.parseInt(request.getParameter("id")));
        
        if (isProductDeleteSuccess) {

            response.sendRedirect("/CrudJavaWebJefferson/products?action=list&isProductDeleteSuccess=true");
        } else {

            response.sendRedirect("/CrudJavaWebJefferson/products?action=list&isProductSuccess=false");
        }
    }
    
}
