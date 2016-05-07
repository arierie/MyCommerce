
package id.arieridwan.mycommerce.model;


public class DataModel {

    private boolean STATUS;
    private int STATUSCODE;
    private MESSAGE MESSAGE;
    private DATA DATA;

    /**
     * 
     * @return
     *     The STATUS
     */
    public boolean isSTATUS() {
        return STATUS;
    }

    /**
     * 
     * @param STATUS
     *     The STATUS
     */
    public void setSTATUS(boolean STATUS) {
        this.STATUS = STATUS;
    }

    /**
     * 
     * @return
     *     The STATUSCODE
     */
    public int getSTATUSCODE() {
        return STATUSCODE;
    }

    /**
     * 
     * @param STATUSCODE
     *     The STATUS_CODE
     */
    public void setSTATUSCODE(int STATUSCODE) {
        this.STATUSCODE = STATUSCODE;
    }

    /**
     * 
     * @return
     *     The MESSAGE
     */
    public MESSAGE getMESSAGE() {
        return MESSAGE;
    }

    /**
     * 
     * @param MESSAGE
     *     The MESSAGE
     */
    public void setMESSAGE(MESSAGE MESSAGE) {
        this.MESSAGE = MESSAGE;
    }

    /**
     * 
     * @return
     *     The DATA
     */
    public DATA getDATA() {
        return DATA;
    }

    /**
     * 
     * @param DATA
     *     The DATA
     */
    public void setDATA(DATA DATA) {
        this.DATA = DATA;
    }

}
