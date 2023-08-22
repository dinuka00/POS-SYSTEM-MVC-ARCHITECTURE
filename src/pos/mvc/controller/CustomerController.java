/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pos.mvc.controller;

import pos.mvc.model.CustomerModel;
import java.sql.Connection;
import pos.mvc.db.DBConnection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author tdamm
 */
public class CustomerController {
    public String saveCustomer(CustomerModel customer) throws SQLException, ClassNotFoundException{
    
        Connection connection = DBConnection.getInstance().getConnection();
        
        String query = "INSERT INTO Customer VALUES(?,?,?,?,?,?,?,?,?)";
        
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, customer.getCustId());
        preparedStatement.setString(2, customer.getCustTitle());
        preparedStatement.setString(3, customer.getCustName());
        preparedStatement.setString(4, customer.getDob());
        preparedStatement.setDouble(5, customer.getSalary());
        preparedStatement.setString(6, customer.getCustAddress());
        preparedStatement.setString(7, customer.getCity());
        preparedStatement.setString(8, customer.getProvince());
        preparedStatement.setString(9, customer.getZip());
        
        if(preparedStatement.executeUpdate() > 0){
            return "Success";
        }else{
            return "fail" ;
        }   
        
    }
    
    public ArrayList<CustomerModel> getAllCustomers() throws SQLException, ClassNotFoundException{
    
         Connection connection = DBConnection.getInstance().getConnection();
         
         String query = "SELECT * FROM Customer";
         
         PreparedStatement statement = connection.prepareStatement(query);
         
         ResultSet rst = statement.executeQuery();
         
         ArrayList<CustomerModel> customerModels = new ArrayList<>();
         
         while(rst.next()){
             CustomerModel cm = new CustomerModel(rst.getString(1),
                     rst.getString(2),
                     rst.getString(3),
                     rst.getString(4),
                     rst.getDouble(5),
                     rst.getString(6),
                     rst.getString(7),
                     rst.getString(8),
                    rst.getString(9));
             
             customerModels.add(cm);
         }
         
         return customerModels;
         
        
    }
}
