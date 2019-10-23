/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datasource;

import java.util.ArrayList;
import model.Bottom;
import model.Top;

/**
 *
 * @author THOMA
 */
interface CupcakeInterface {
    
    
    
    public ArrayList <Bottom> getBottoms();
    
    public ArrayList <Top> getTops();
    
    public Bottom getBottomFromID (int ID);
    
    public Top getTopFromID (int ID);
    
    
    
    
    
    
}
