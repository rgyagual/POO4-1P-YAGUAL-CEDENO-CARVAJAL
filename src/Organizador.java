public class Organizador {
    private String empresa;
    private String cargo;

    public Organizador(String empresa, String cargo){
        this.empresa=empresa;
        this.cargo=cargo;
    }

    public String getEmpresa(){
        return this.empresa;
    }

    public void setEmpresa(String empresa){
        this.empresa=empresa;
    }

    public String getCargo(){
        return this.cargo;
    }
    
    public void setCargo(String cargo){
        this.cargo=cargo;
    }
    
}
