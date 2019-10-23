package model;

import com.datastax.driver.mapping.annotations.UDT;

import java.util.List;

@UDT(keyspace = "phone_webapp", name = "main_camera")
public class MainCamera {

    private List<String> camera;
    private List<String> feature;
    private List<String> video;

    public List<String> getCamera() {
        return camera;
    }

    public void setCamera(List<String> camera) {
        this.camera = camera;
    }

    public List<String> getFeature() {
        return feature;
    }

    public void setFeature(List<String> feature) {
        this.feature = feature;
    }

    public List<String> getVideo() {
        return video;
    }

    public void setVideo(List<String> video) {
        this.video = video;
    }

    @Override
    public String toString() {
        return "MainCamera{" +
                "camera=" + camera +
                ", feature=" + feature +
                ", video=" + video +
                '}';
    }

}
