import java.util.ArrayList;
import java.util.List;

public class EcoSistema {

    private List<Usuario> usuarios;

    // Getter del listado
    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    // Crear lista
    public EcoSistema() {
        usuarios = new ArrayList<>();
    }

    // Agregar usuario
    public void agregar(Usuario u) {
        usuarios.add(u);
    }

    // Editar usuario por ID (búsqueda binaria como en Liga)
    public boolean editar(int id, Usuario nuevo) {
        int i = 0;
        int s = usuarios.size() - 1;
        int c;

        while (i <= s) {
            c = (i + s) / 2;

            if (usuarios.get(c).getId() == id) {
                usuarios.set(c, nuevo);
                return true;
            } else if (id < usuarios.get(c).getId()) {
                s = c - 1;
            } else {
                i = c + 1;
            }
        }
        return false;  // No encontrado
    }

    // Mostrar todos
    public List<Usuario> todos() {
        return usuarios;
    }

    //Buscar algo en la lista
    public Usuario buscar(int id) {
        for (Usuario u : usuarios) {
            if (u.getId() == id) {
                return u;   // lo encontró
            }
        }
        return null; // no existe
    }
}

