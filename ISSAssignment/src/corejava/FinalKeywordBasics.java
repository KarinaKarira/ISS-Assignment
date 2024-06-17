//This example demonstrates the use of final keyword

//final keyword can be used to achieve the following tasks
//1.To create a constant
//2.To prevent overriding
//3.To provide inheritance
package corejava;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

class Operation{
    final double pi=3.1415;
    private int num1;
    private int num2;

    public int getNum1() {
        return num1;
    }

    public final void setNum1(int num1) {
        this.num1 = num1;
    }

    public int getNum2() {
        return num2;
    }

    public final void setNum2(int num2) {
        this.num2 = num2;
    }

}
//if we make class Operation as final, we cannot extend it
class Addition extends Operation{
     Addition(){
         //we cannot change the value of a final variable
//         pi=3.57
     }

     public int add(){
         return this.getNum1()+this.getNum2();
     }

//     we cannot override the setNum1/setNum2 methods because they are declared final
//     public void setNum1(int num1){
//
//     }
}

public class FinalKeywordBasics {
    static Logger logger= Logger.getLogger(FinalKeywordBasics.class);

    public static void main(String[] args){
        String log4jConfigFile="src/main/resources/log4j.properties";
        PropertyConfigurator.configure(log4jConfigFile);

        Addition additionObj=new Addition();
        additionObj.setNum1(10);
        additionObj.setNum2(20);

        logger.info("Value of addition is:"+additionObj.add());
    }
}
