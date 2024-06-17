package corejava;

public class Parent{
    private int private_var;
    protected int protected_var;
    int default_var;
    public int public_var;

    public Parent(){
        private_var=9;
        protected_var=10;
        default_var=11;
        public_var=12;
    }
    public int getPrivate_var() {
        return private_var;
    }

    public void setPrivate_var(int private_var) {
        this.private_var = private_var;
    }

}
