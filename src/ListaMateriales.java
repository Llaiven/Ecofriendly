import java.util.ArrayList;
import java.util.List;

public class ListaMateriales {

    private List<MaterialReciclado> materiales;

    public ListaMateriales() {
        materiales = new ArrayList<>();
    }

    public void agregar(MaterialReciclado m) {
        materiales.add(m);
    }

    public List<MaterialReciclado> todos() {
        return materiales;
    }
}

