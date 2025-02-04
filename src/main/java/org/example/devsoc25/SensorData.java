package org.example.devsoc25;

public class SensorData {
    private String Species;
    private int Soil_Moisture;
    private int Ambient_Temperature;
    private int Humidity;
    private int Light_Intensity;

    public SensorData() {
    }

    public SensorData(int Soil_Moisture, int Ambient_Temperature, int Humidity, int Light_Intensity) {
        this.Soil_Moisture = Soil_Moisture;
        this.Ambient_Temperature = Ambient_Temperature;
        this.Humidity = Humidity;
        this.Light_Intensity = Light_Intensity;
    }

    public int getSoil_Moisture() {
        return Soil_Moisture;
    }

    public void setSoil_Moisture(int Soil_Moisture) {
        this.Soil_Moisture = Soil_Moisture;
    }

    public int getAmbient_Temperature() {
        return Ambient_Temperature;
    }

    public void setAmbient_Temperature(int Ambient_Temperature) {
        this.Ambient_Temperature = Ambient_Temperature;
    }

    public int getHumidity() {
        return Humidity;
    }

    public void setHumidity(int Humidity) {
        this.Humidity = Humidity;
    }

    public int getLight_Intensity() {
        return Light_Intensity;
    }

    public void setLight_Intensity(int Light_Intensity) {
        this.Light_Intensity = Light_Intensity;
    }

    @Override
    public String toString() {
        return "SensorData{" +
                "Soil_Moisture=" + Soil_Moisture +
                ", Ambient_Temperature=" + Ambient_Temperature +
                ", Humidity=" + Humidity +
                ", Light_Intensity=" + Light_Intensity +
                '}';
    }
}
