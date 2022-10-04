package com.example.renato_llivisaca_exam.Api;

import com.example.renato_llivisaca_exam.Usuarios;

import java.util.List;

public class ResObject {
    private boolean status;
    private List<Usuarios> objects;

    public ResObject() {
    }

    public ResObject(boolean status, List<Usuarios> objects) {
        this.status = status;
        this.objects = objects;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public List<Usuarios> getObjects() {
        return objects;
    }

    public void setObjects(List<Usuarios> objects) {
        this.objects = objects;
    }
}
