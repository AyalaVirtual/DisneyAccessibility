package org.example.model.attractionaccessibilityattributes;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;


@Embeddable
public class AssistiveDevices {
    private boolean assistiveListening;
    private boolean audioDescription;
    private boolean handheldCaptioning;
    private boolean signLanguage;
    private boolean videoCaptioning;


    public AssistiveDevices() {
    }

    public AssistiveDevices(boolean assistiveListening, boolean audioDescription, boolean handheldCaptioning, boolean signLanguage, boolean videoCaptioning) {
        this.assistiveListening = assistiveListening;
        this.audioDescription = audioDescription;
        this.handheldCaptioning = handheldCaptioning;
        this.signLanguage = signLanguage;
        this.videoCaptioning = videoCaptioning;
    }


    public boolean getAssistiveListening() {
        return assistiveListening;
    }

    public void setAssistiveListening(boolean assistiveListening) {
        this.assistiveListening = assistiveListening;
    }

    public boolean getAudioDescription() {
        return audioDescription;
    }

    public void setAudioDescription(boolean audioDescription) {
        this.audioDescription = audioDescription;
    }

    public boolean getHandheldCaptioning() {
        return handheldCaptioning;
    }

    public void setHandheldCaptioning(boolean handheldCaptioning) {
        this.handheldCaptioning = handheldCaptioning;
    }

    public boolean getSignLanguage() {
        return signLanguage;
    }

    public void setSignLanguage(boolean signLanguage) {
        this.signLanguage = signLanguage;
    }

    public boolean getVideoCaptioning() {
        return videoCaptioning;
    }

    public void setVideoCaptioning(boolean videoCaptioning) {
        this.videoCaptioning = videoCaptioning;
    }


    @Override
    public String toString() {
        return "AssistiveDevices{" +
                "assistiveListening=" + assistiveListening +
                ", audioDescription=" + audioDescription +
                ", handheldCaptioning=" + handheldCaptioning +
                ", signLanguage=" + signLanguage +
                ", videoCaptioning=" + videoCaptioning +
                '}';
    }
}
