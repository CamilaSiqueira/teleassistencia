package util.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Camila Siqueira
 */
@FacesConverter(value = "convertTelefone")
public class TelefoneConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext arg0, UIComponent arg1, String valor) {
        if (valor != null || valor != "") {
            valor = valor.toString().replaceAll("[- ()]", "");
        }
        return valor;
    }

    @Override
    public String getAsString(FacesContext arg0, UIComponent arg1, Object valor) throws ConverterException {
        if (valor == null) {
            return "";
        }

        String v = valor.toString();
        return "(" + v.substring(0, 3) + ") " + v.substring(3, 7) + "-" + v.substring(7, 11);
    }
}
