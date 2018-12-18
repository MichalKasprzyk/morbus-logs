package symbiosproduction.com.morbuslogs.database.model.symptoms.pain;


import android.os.Parcel;
import android.os.Parcelable;

import java.util.HashMap;
import java.util.Map;

import symbiosproduction.com.morbuslogs.database.model.symptoms.AbstractSymptom;

public final class PainSymptom extends AbstractSymptom {

    private String intensity;
    private PainType painType;


    @Override
    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);
        dest.writeString(intensity);
        dest.writeString(painType.toString());
    }

    public static final Parcelable.Creator<PainSymptom> CREATOR
            = new Parcelable.Creator<PainSymptom>() {
        public PainSymptom createFromParcel(Parcel in) {
            return new PainSymptom(in);
        }

        public PainSymptom[] newArray(int size) {
            return new PainSymptom[size];
        }
    };


    //@TODO: Add picture of pain area?

    private PainSymptom(Parcel in) {
        super(in);
        intensity = in.readString();
        painType = PainType.valueOf(in.readString());
    }

    public PainSymptom(String intensity,
                       PainType painType,
                       String description,
                       Long duration,
                       String timeUnit,
                       String dateOfOccurrence,
                       String symptomName) {
        super(dateOfOccurrence, timeUnit, duration, description, symptomName);
        this.intensity = intensity;
        this.painType = painType;
    }

    @Override
    public Map<String, Object> toMap() {

        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put("symptomName", symptomName);
        dataMap.put("dateOfOccurrence", dateOfOccurrence);
        dataMap.put("duration", duration);
        dataMap.put("description", description);
        dataMap.put("intensity", intensity);
        dataMap.put("painType", painType.toString());


        return dataMap;
    }
}