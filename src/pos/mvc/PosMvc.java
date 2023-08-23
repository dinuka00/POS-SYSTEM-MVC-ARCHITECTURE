/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pos.mvc;

import pos.mvc.view.CustomerView;
import pos.mvc.view.ItemView;
import pos.mvc.view.MainView;
import pos.mvc.view.MenuView;
import pos.mvc.view.OrderView;

/**
 *
 * @author tdamm
 */
public class PosMvc {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // new CustomerView().setVisible(true);
        // new ItemView().setVisible(true);    
        //new OrderView().setVisible(true);

        new MenuView().setVisible(true);
    }

}
