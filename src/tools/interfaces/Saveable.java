/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools.interfaces;

import java.util.List;

/**
 *
 * @author user
 */
public interface Saveable {
    public void saveToFile(List arrayList, String fileName);
    public List loadFromFile(String fileName);
}
