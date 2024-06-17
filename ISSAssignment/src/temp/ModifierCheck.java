//this is a different package to demonstrate the access modifier 'protected'
package temp;
import corejava.Parent;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

class Child extends corejava.Parent{
    //we only have access to protected and public variables here
    Child(){
        protected_var=9000;
        public_var=1200;
    }
//    public void checkScope(){
//
//        this.protected_var=9000;
//        this.public_var=1200;
//    }
}
public class ModifierCheck {

    static Logger logger= Logger.getLogger(ModifierCheck.class);
    public static void main(String[] args){

        String log4jConfigFile="src/main/resources/log4j.properties";
        PropertyConfigurator.configure(log4jConfigFile);

        Child child=new Child();
        logger.info("We don't have the access to the protected variable");
        logger.info("The value of public variable of child from other package is:"+child.public_var);
    }

}
