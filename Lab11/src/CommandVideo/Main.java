package CommandVideo;


public class Main {
    public static void main(String[] args) {

        ReproductorMusica reproductor = new ReproductorMusica();
        
        Command play = new PlayCommand(reproductor);
        Command stop = new StopCommand(reproductor);
        Command subirVolumen = new SubirVolumenCommand(reproductor);
        Command bajarVolumen = new BajarVolumenCommand(reproductor);
        Command next = new SiguienteCancionCommand(reproductor);
        
        ControlRemoto control = new ControlRemoto();
        
        
        System.out.println("PRUEBA 1");
        
        control.setCommand(play);
        control.presionarBoton();
        
        control.setCommand(subirVolumen);
        control.presionarBoton();
        control.presionarBoton();
        
        
        
        control.setCommand(next);
        control.presionarBoton();
        

        control.setCommand(stop);
        control.presionarBoton();
    }
}
