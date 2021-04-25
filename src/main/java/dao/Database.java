package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import models.*;

public class Database {
	public Connection connection;
	public Connection connect() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            this.connection = DriverManager.getConnection(
            		"jdbc:mysql://mysql-25485-0.cloudclusters.net:25485/microprojet","soufiane","soufiane");
            System.out.println("Connection.");
            return connection;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

	 public int registerEmployee(User employee) throws ClassNotFoundException, SQLException {
	        String INSERT_USERS_SQL = "INSERT INTO clients" +
	            "  (email, nom, prenom, adresse, codepostale, tel, motpasse) VALUES " +
	            " (?, ?, ?, ?, ?,?,?);";

	        int result = 0;

	      PreparedStatement preparedStatement =  connect().prepareStatement(INSERT_USERS_SQL);

	            //preparedStatement.setInt(1, 1);
	            preparedStatement.setString(1, employee.getEmail());
	            preparedStatement.setString(2, employee.getNom());
	            preparedStatement.setString(3, employee.getPrenom());
	            preparedStatement.setString(4, employee.getAdresse());
	            preparedStatement.setString(5, employee.getCodepostal());
	            preparedStatement.setString(6, employee.getTel());
	            preparedStatement.setString(7, employee.getMotdepasse());

	            System.out.println(preparedStatement);
	            // Step 3: Execute the query or update query
	            result = preparedStatement.executeUpdate();

	      
	        return result;
	    }
	 public boolean validate(User user) throws ClassNotFoundException, SQLException {
			boolean status = false;

			
					   PreparedStatement preparedStatement =  connect().prepareStatement("select * from clients where email = ? and motpasse = ? ");
					// Step 2:Create a statement using connection object
					
				preparedStatement.setString(1, user.getEmail());
				preparedStatement.setString(2, user.getMotdepasse());
				
				System.out.println(preparedStatement);
				
				ResultSet rs = preparedStatement.executeQuery();
				
				
				status = rs.next();
				

			
			return status;
		}
	 public User setAttributes(User user) throws ClassNotFoundException, SQLException {
		 			

				PreparedStatement preparedStatement =  connect().prepareStatement("select * from clients where email = ? and motpasse = ? ");
				preparedStatement.setString(1, user.getEmail());
				preparedStatement.setString(2, user.getMotdepasse());			
				System.out.println(preparedStatement);	
				ResultSet rs = preparedStatement.executeQuery();
				rs.next();
				user.setNom(rs.getString("nom"));
				user.setPrenom(rs.getString("prenom"));
				user.setAdresse((rs.getString("adresse")));
				user.setCodepostal(rs.getString("codepostale"));
				user.setTel(rs.getString("tel"));

		 return user;
	 }
	 public Article SetArticle(Article article) throws SQLException {
			PreparedStatement preparedStatement =  connect().prepareStatement("select * from articles where codearticle = ?");
			preparedStatement.setString(1, ""+article.getCodearticle());
			System.out.println(preparedStatement);	
			ResultSet rs = preparedStatement.executeQuery();
			rs.next();
			article.setCategorie(rs.getString("categorie"));
			article.setDesignation(rs.getString("designation"));
			article.setPhoto(rs.getString("photo"));
			article.setPrix(Double.parseDouble(rs.getString("prix")));
			article.setStock(Integer.parseInt(rs.getString("stock")));
			
		 return article;
	 }

	   public List<Article> getAllArticles() throws Exception {
	        List<Article> articlesList = new ArrayList<>();

	        String query = "SELECT *  FROM articles";
	        ResultSet res = connect().createStatement().executeQuery(query);
	        System.out.println(res);
	        while (res.next())
	        {
	        	 articlesList.add(new Article(res.getInt("codearticle"), res.getString("designation"), res.getInt("stock"), res.getString("categorie"),
	        	            res.getDouble("prix"), res.getString("photo")
	        	            ));
	        }

	        return articlesList;
	    }
	   public List<Article> getArticlesByCat(String categorie){
			
			List<Article> articles=new ArrayList<Article>();
			try{
				PreparedStatement preparedStatement =  connect().prepareStatement("select * from articles where categorie=?");
		        
				preparedStatement.setString(1,categorie);
				ResultSet rs=preparedStatement.executeQuery();
		         // Extract data from result set
		         while(rs.next()){
		            //Retrieve by column name
		        	 Article article=new Article();
		        	 article.setCategorie(categorie);
		        	 article.setCodearticle(rs.getInt("codearticle"));
		        	 article.setDesignation(rs.getString("designation"));
		 			article.setPhoto(rs.getString("photo"));
		 			article.setPrix(Double.parseDouble(rs.getString("prix")));
		 			article.setStock(Integer.parseInt(rs.getString("stock")));
		            
		            articles.add(article);
		            //System.out.println(article.getDesignation());
		         }
		         rs.close();
		      }catch(SQLException se){
		         //Handle errors for JDBC
		         se.printStackTrace();
		      }catch(Exception e){
		         //Handle errors for Class.forName
		         e.printStackTrace();
		      }
			
			
			return articles;
		}
	   

}
