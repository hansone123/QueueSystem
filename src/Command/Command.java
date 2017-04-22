/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Command;

/**
 *
 * @author Hanson
 */
abstract public class Command {
    abstract public void execute();
    abstract public void undo();
}
