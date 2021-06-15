package sandbox.mapa;



public enum ModeloECU
{
  FUEL_INJECT(31, "Fuel Inject", "/images/ecu/fuel_inject.png", true),
  POWER_INJECT(11, "Power Inject", "/images/ecu/power_inject.png", true),
  POWER_INJECT_LCD(12, "Power Inject", "/images/ecu/power_inject_lcd.png", true),
  PRO_INJECT(41, "Pro Inject", "/images/ecu/pro_inject.png", true),
  BOX_INJECT(1, "Box Inject", "/images/ecu/box_inject.png", true),
  MONITOR_CAN(81, "Box Inject Monitor", "/images/ecu/monitor_can.png", false);
  
  private final int id;
  private final String nome;
  private final String imagem;
  private final boolean ecu;
  
  ModeloECU(int id, String nome, String imagem, boolean ecu) {
    this.id = id;
    this.nome = nome;
    this.imagem = imagem;
    this.ecu = ecu;
  }





  
  public int getId() {
    return this.id;
  }





  
  public String getNome() {
    return this.nome;
  }





  
  public String getImagem() {
    return this.imagem;
  }





  
  public boolean isEcu() {
    return this.ecu;
  }
  
  public static ModeloECU getById(int id) {
    ModeloECU retorno = null;

    
    for (ModeloECU modulo : values()) {
      
      if (modulo.getId() == id) {
        
        retorno = modulo;
        
        break;
      } 
    } 
    
    return retorno;
  }
}
