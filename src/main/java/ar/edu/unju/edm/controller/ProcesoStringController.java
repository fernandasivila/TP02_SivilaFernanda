package ar.edu.unju.edm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.edm.model.ProcesoString;

@Controller
public class ProcesoStringController {
	
	@GetMapping("/procesoString")
	public ModelAndView cargarString() {
		ProcesoString nuevoString = new ProcesoString();
		
		ModelAndView modelAndView = new ModelAndView("procesoString");
		modelAndView.addObject("stringNuevo", nuevoString);
		
		return modelAndView;
	}
	
	@PostMapping("/mostrarString")
	public ModelAndView guardarString (@ModelAttribute ("stringNuevo") ProcesoString nuevoString) {
		System.out.println(nuevoString);
		String[] mensajes=invertirCadena(nuevoString.getCadena());
		
		nuevoString.setMensaje1(determinarLongitud(nuevoString.getCadena()));
		nuevoString.setCadenaInvertida(mensajes[0]);
		nuevoString.setMensaje2(mensajes[1]);
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("stringNuevo", nuevoString);
		return modelAndView;
	}
	
	public String determinarLongitud(String cadena) {
		Integer caracteres=0;
		Integer vocales=0;
		String aux=null;
		
		for(int i=0;i<cadena.length();i++) {
			if(cadena.charAt(i)!=' ') {
				caracteres++;
				if(cadena.charAt(i)=='a' || cadena.charAt(i)=='e' || cadena.charAt(i)=='i' || cadena.charAt(i)=='o' || cadena.charAt(i)=='u' || cadena.charAt(i)=='A' || cadena.charAt(i)=='E' || cadena.charAt(i)=='I' || cadena.charAt(i)=='O' || cadena.charAt(i)=='U') {
					vocales++;
				}
			}
		}
		
		aux="La cadena tiene " + caracteres + " caracteres y " + vocales + " vocales";
	    
	    return aux;
	}
	
	public String[] invertirCadena(String cadena) {
		String cadenaInvertida="";
		String[] palabras=cadena.split("\\s+");
		String cantidadPalabras=null;
		
		for(int i=cadena.length()-1;i>=0;i--) {
			if(cadena.charAt(i)!=' ') {
				cadenaInvertida=cadenaInvertida+cadena.charAt(i);
			}
		}
		
		
		cantidadPalabras="La cadena tiene " + palabras.length + " palabras";
		
		String[] mensajes= {cadenaInvertida,cantidadPalabras};
		
		return mensajes;
		
	}

}
