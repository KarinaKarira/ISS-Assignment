//This example demonstrates the use and types of access modifiers

package corejava;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

class Child extends Parent{
    Child(){
        //cannot use private variable of the parent
        protected_var=100;
        default_var=110;
        public_var=120;
    }

}

public class ModifierBasics {

    static Logger logger= Logger.getLogger(ModifierBasics.class);

    public static void main(String[] args){

        String log4jConfigFile="src/main/resources/log4j.properties";
        PropertyConfigurator.configure(log4jConfigFile);

        Parent parent=new Parent();
        parent.protected_var=10;   //we can use protected variable since it is within the same package

        //we can't access the private variable of the class directly
        parent.setPrivate_var(90);
        logger.info("Value of private variable for parent object is:"+parent.getPrivate_var());
        logger.info("Value of protected variable for parent object is:"+parent.protected_var);
        logger.info("Value of default variable for parent object is:"+parent.default_var);
        logger.info("Value of public variable for parent object is:"+parent.public_var);

        //checking the values that the child class has.Child does not have the access to private members of the parent.so it uses getter and setter methods for the same

        Child child=new Child();
        child.setPrivate_var(900);

        logger.info("Value of private variable for child object is:"+child.getPrivate_var());
        logger.info("Value of protected variable for child object is:"+child.protected_var);
        logger.info("Value of default variable for child object is:"+child.default_var);
        logger.info("Value of public variable for child object is:"+child.public_var);


        //900 100 110 120
    }
}
