package Controllers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import Models.data.CategoriesDAO_JDBC;
import Models.domain.CategoriesDTO;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.RequestDispatcher;

@WebServlet(name = "Categories")
public class ControllerCategories extends HttpServlet {

    CategoriesDAO_JDBC categoriesDAO_JDBC = new CategoriesDAO_JDBC();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

       doGet(request, response);
    }

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
                case "addCategory":
                        addCategory(request, response);
                        break;
                case "editView":
                        editView(request, response);
                        break;
                case "editCategory":
                        editCategory(request, response);
                        break;
                default:
                        break;
                }			
        } catch (SQLException e) {
                e.getStackTrace();
        }	
    }
    
    private void list(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException , ServletException{
		
        RequestDispatcher dispatcher = request.getRequestDispatcher("/views/Categories.jsp");
        List<CategoriesDTO> products = categoriesDAO_JDBC.select();
        request.setAttribute("categoriesList", products);
        dispatcher.forward(request, response);
    }
    
    private void addView(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException , ServletException{
		
        RequestDispatcher dispatcher = request.getRequestDispatcher("/views/Categories.jsp");
        dispatcher.forward(request, response);
    }
    
    private void addCategory(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException , ServletException{
		
        boolean isCayegorySuccess = false;
        CategoriesDTO category = new CategoriesDTO();
        category.setName(request.getParameter("name"));
        
        isCayegorySuccess = categoriesDAO_JDBC.insert(category);
        
        if (isCayegorySuccess) {

            response.sendRedirect("/CrudJavaWebJefferson/categories?action=list&isCategorySuccess=true");
            
        } else {

            response.sendRedirect("/CrudJavaWebJefferson/categories?action=list&isCategorySuccess=false");
        }
    }
     
    private void editView(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException , ServletException{
		
        RequestDispatcher dispatcher = request.getRequestDispatcher("/views/Categories.jsp");
        request.setAttribute("category", categoriesDAO_JDBC.getById(Integer.parseInt(request.getParameter("id"))));
        dispatcher.forward(request, response);
    }
    
    private void editCategory(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException , ServletException{
		
        boolean isCategorySuccess = false;
        CategoriesDTO category = new CategoriesDTO();
        category.setIdCategory(Integer.parseInt(request.getParameter("id")));
        category.setName(request.getParameter("name"));
        
        isCategorySuccess = categoriesDAO_JDBC.update(category);
        
        if (isCategorySuccess) {

            response.sendRedirect("/CrudJavaWebJefferson/categories?action=list&isCategoryEditSuccess=true");
        } else {

            response.sendRedirect("/CrudJavaWebJefferson/categories?action=list&isCategorySuccess=false");
        }
    }
}
