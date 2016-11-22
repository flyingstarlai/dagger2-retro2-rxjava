package dev.starlai.dagger2retro.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by izayoi on 11/22/2016.
 */

public class Mclass {

    @SerializedName("CLASS")
    @Expose
    private String cLASS;
    @SerializedName("CLASSNA")
    @Expose
    private String cLASSNA;

    /**
     *
     * @return
     * The cLASS
     */
    public String getCLASS() {
        return cLASS;
    }

    /**
     *
     * @param cLASS
     * The CLASS
     */
    public void setCLASS(String cLASS) {
        this.cLASS = cLASS;
    }

    /**
     *
     * @return
     * The cLASSNA
     */
    public String getCLASSNA() {
        return cLASSNA;
    }

    /**
     *
     * @param cLASSNA
     * The CLASSNA
     */
    public void setCLASSNA(String cLASSNA) {
        this.cLASSNA = cLASSNA;
    }
}
