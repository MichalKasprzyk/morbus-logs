package symbiosproduction.com.morbuslogs.database.model.symptoms.temperature;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.HashMap;
import java.util.Map;

import symbiosproduction.com.morbuslogs.database.model.symptoms.AbstractSymptom;

public final class AbnormalTempSymptom extends AbstractSymptom {


    private Integer tempInCelsius;



    public AbnormalTempSymptom(String dateOfOccurrence,
                               Long duration,
                               String timeUnit,
                               String description,
                               Integer tempInCelsius,
                               String symptomName)
    {
        super(dateOfOccurrence,timeUnit,duration,description, symptomName);
        this.tempInCelsius = tempInCelsius;
    }

    public static final Parcelable.Creator<AbnormalTempSymptom> CREATOR
            = new Parcelable.Creator<AbnormalTempSymptom>() {
        public AbnormalTempSymptom createFromParcel(Parcel in) {
            return new AbnormalTempSymptom(in);
        }

        public AbnormalTempSymptom[] newArray(int size) {
            return new AbnormalTempSymptom[size];
        }
    };

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);
        dest.writeInt(tempInCelsius);
    }

    private AbnormalTempSymptom(Parcel in)
    {
        super(in);
        tempInCelsius = in.readInt();
    }

    public Integer getTempInCelsius() {
        return tempInCelsius;
    }


    @Override
    public Map<String, Object> toMap() {

        Map<String, Object> dataMap = new HashMap<>();

        dataMap.put("symptomName", symptomName);
        dataMap.put("dateOfOccurrence", dateOfOccurrence);
        dataMap.put("duration", duration);
        dataMap.put("description", description);
        dataMap.put("tempInCelsius", tempInCelsius);

        return dataMap;
    }
}