package ar.edu.unju.edm.controller;

import java.time.LocalDate;
import java.time.Period;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.edm.model.ProcesoFecha;

@Controller
public class ProcesoFechaController {
	
    @GetMapping("/procesoFecha")
	public ModelAndView cargarFecha() {
    	ModelAndView modelAndView = new ModelAndView("procesoFecha");
    	ProcesoFecha nuevaFecha = new ProcesoFecha();
    	
    	modelAndView.addObject("fechaNueva", nuevaFecha);
    	
    	return modelAndView;
    }
	
	@PostMapping("/mostrarFecha")
	
	public ModelAndView guardarFecha(@ModelAttribute ("fechaNueva") ProcesoFecha fechaGuardar) {
		String mensajes[]=compararFechas(fechaGuardar.getFecha1(),fechaGuardar.getFecha2());
		System.out.println(fechaGuardar);
		
		fechaGuardar.setMensaje1(mensajes[0]);
		fechaGuardar.setMensaje2(mensajes[1]);
		
		ModelAndView modelAndView = new ModelAndView("mostrarProcesoFecha");
		modelAndView.addObject("fechaNueva", fechaGuardar);
		
		return modelAndView;
	}
	
	public String[] compararFechas (LocalDate fecha1, LocalDate fecha2) {
		String mensaje1;
		String mensaje2;
		Period periodo;
		if(fecha1.isAfter(fecha2)) {
			mensaje1="La fecha1 es porterior a la fecha2";
			periodo = Period.between(fecha2, fecha1);
		}
		else{
			if(fecha2.isAfter(fecha1)){
				mensaje1="La fecha1 es anterior a fecha2";
				periodo = Period.between(fecha1, fecha2);
			}
			else {
				mensaje1="Las fechas son iguales";
				periodo = Period.between(fecha1, fecha2);
			}
		}
		
		mensaje2="Han transcurrido " + periodo.getYears() + " años, " + periodo.getMonths() + " meses y " + periodo.getDays() + " dias desde la fecha menor hasta la fecha mayor";
		
		String mensajes[]= {mensaje1,mensaje2};
		
		return mensajes;
	}
	


}
