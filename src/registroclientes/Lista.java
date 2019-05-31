package registroclientes;

import javax.swing.JOptionPane;

public class Lista {

    private Nodo top;
    private int tamaño;

    public Lista() {
        this.top = null;
        this.tamaño = 0;
    }

    public int getTamaño() {
        return tamaño;
    }

    public void setTamaño(int tamaño) {
        this.tamaño = tamaño;
    }

    public boolean esVacia() {
        return top == null;
    }

    public void insertarInicio(Cliente persona) {
        Nodo nuevoNodo = new Nodo();
        nuevoNodo.setDNI(persona.getDNI());
        nuevoNodo.setDireccion(persona.getDireccion());
        nuevoNodo.setEmail(persona.getDireccion());
        nuevoNodo.setNombre(persona.getNombre());
        nuevoNodo.setTelefono(persona.getTelefono());
        if (esVacia()) {
            top = nuevoNodo;
        } else {
            nuevoNodo.setSgte(top);
            top = nuevoNodo;
        }
        this.tamaño++;
    }

    public void insertarFinal(Cliente persona) {
        Nodo nuevoNodo = new Nodo();
        nuevoNodo.setDNI(persona.getDNI());
        nuevoNodo.setDireccion(persona.getDireccion());
        nuevoNodo.setEmail(persona.getDireccion());
        nuevoNodo.setNombre(persona.getNombre());
        nuevoNodo.setTelefono(persona.getTelefono());
        if (esVacia()) {
            top = nuevoNodo;
        } else {
            Nodo temporal = top;
            while (temporal.getSgte() != null) {
                temporal = temporal.getSgte();
            }
            temporal.setSgte(nuevoNodo);
        }
        this.tamaño++;
    }

    public void eliminarElemento(String DNI) {
        if (esVacia()) {
            JOptionPane.showMessageDialog(null, "No existen clientes para eliminar");
        } else {
            if (top.getDNI().equals(DNI)) {
                top = top.getSgte();
            } else {
                Nodo temporal = top;
                while (temporal.getSgte() != null && !(temporal.getSgte().getDNI().equals(DNI))) {
                    temporal = temporal.getSgte();
                }
                if (temporal.getSgte() == null) {
                    JOptionPane.showMessageDialog(null, "No existe un cliente con el DNI ingresado");
                } else {
                    temporal.setSgte(temporal.getSgte().getSgte());
                }
            }
            this.tamaño--;
        }
    }

    public void insertarTabla() {
        Nodo temporal = top;
        while (temporal != null) {
            VentanaRegistroClientes.objeto[0] = temporal.getDNI();
            VentanaRegistroClientes.objeto[1] = temporal.getNombre();
            VentanaRegistroClientes.objeto[2] = temporal.getDireccion();
            VentanaRegistroClientes.objeto[3] = temporal.getTelefono();
            VentanaRegistroClientes.objeto[4] = temporal.getEmail();
            VentanaRegistroClientes.modelo.addRow(VentanaRegistroClientes.objeto);
            temporal = temporal.getSgte();
        }
    }

    public Nodo buscarIndice(int indice) {
        Nodo temporal = top;
        int contador = 0;
        while (temporal != null && contador != indice) {
            temporal = temporal.getSgte();
            contador++;
        }
        return temporal;
    }

    public void modificarElemento(Cliente persona, int indice) {
        buscarIndice(indice).setDNI(persona.getDNI());
        buscarIndice(indice).setNombre(persona.getNombre());
        buscarIndice(indice).setDireccion(persona.getDireccion());
        buscarIndice(indice).setTelefono(persona.getTelefono());
        buscarIndice(indice).setEmail(persona.getEmail());
    }

}
