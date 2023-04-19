package ar.edu.unju.edm.controller;

import ar.edu.unju.edm.model.Persona;
import java.time.LocalDate;
import java.time.Period;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PersonaController {
	
	
	@GetMapping("/persona")
	public ModelAndView cargarPersona() {
		ModelAndView modelAndView = new ModelAndView("persona");
		Persona nuevaPersona = new Persona();
		
		modelAndView.addObject("personaNueva", nuevaPersona);
		
		return modelAndView;
		
	}
	
	@PostMapping("/mostrarPersona")
	public ModelAndView guardarPersona(@ModelAttribute ("personaNueva") Persona personaGuardar){
		System.out.println(personaGuardar);
		
		personaGuardar.setEdad(determinarEdad(personaGuardar.getFechaNacimiento()));
		personaGuardar.setEstacionNacida(determinarEstacionDelAño(personaGuardar.getFechaNacimiento()));
		personaGuardar.setSignoZodiacal(determinarSigno(personaGuardar.getFechaNacimiento()));
		
		ModelAndView modelAndView = new ModelAndView("mostrarPersona");
		modelAndView.addObject("personaNueva",personaGuardar);
		return modelAndView;
	}
	
	public Integer determinarEdad (LocalDate fechaNacimiento) {
		LocalDate fechaActual = LocalDate.now();
		Period periodo = Period.between(fechaNacimiento, fechaActual);
		
		return periodo.getYears();
	}
	
	public String determinarSigno (LocalDate fechaNacimiento) {
		String aux=null;
		Integer dia=fechaNacimiento.getDayOfMonth();
		Integer mes=fechaNacimiento.getMonthValue();
		
		switch(mes) {
		case 1: if(dia>=1 && dia<=20) {
			aux="Capricornio";
		}
		else {
			if(dia>=21 && dia<=31) {
				aux="Acuario";
			}
		}
		break;
		case 2: if(dia>=1 && dia<=19) {
			aux="Acuario";
		}
		else {
			if(dia>=20 && dia<=29) {
				aux="Piscis";
			}
		}
		break;
		case 3: if(dia>=1 && dia<=20) {
			aux="Piscis";
		}
		else {
			if(dia>=21 && dia<=31) {
				aux="Aries";
			}
		}
		break;
		case 4: if(dia>=1 && dia<=20) {
			aux="Aries";
		}
		else {
			if(dia>=21 && dia<=30) {
				aux="Tauro";
			}
		}
		break;
		case 5: if(dia>=1 && dia<=20) {
			aux="Tauro";
		}
		else {
			if(dia>=21 && dia<=31) {
				aux="Geminis";
			}
		}
		break;
		case 6: if(dia>=1 && dia<=20) {
			aux="Geminis";
		}
		else {
			if(dia>=21 && dia<=30) {
				aux="Cancer";
			}
		}
		break;
		case 7: if(dia>=1 && dia<=21) {
			aux="Cancer";
		}
		else {
			if(dia>=22 && dia<=31) {
				aux="Leo";
			}
		}
		break;
		case 8: if(dia>=1 && dia<=23) {
			aux="Leo";
		}
		else {
			if(dia>=24 && dia<=31) {
				aux="Virgo";
			}
		}
		break;
		case 9: if(dia>=1 && dia<=22) {
			aux="Virgo";
		}
		else {
			if(dia>=23 && dia<=30) {
				aux="Libra";
			}
		}
		break;
		case 10: if(dia>=1 && dia<=22) {
			aux="Libra";
		}
		else {
			if(dia>=23 && dia<=31) {
				aux="Escorpio";
			}
		}
		break;
		case 11: if(dia>=1 && dia<=22) {
			aux="Escorpio";
		}
		else {
			if(dia>=23 && dia<=30) {
				aux="Sagitario";
			}
		}
		break;
		case 12: if(dia>=1 && dia<=21) {
			aux="Sagitario";
		}
		else {
			if(dia>=22 && dia<=31) {
				aux="Capricornio";
			}
		}
		break;
		}
		
		return aux;
	}

	public String determinarEstacionDelAño (LocalDate fechaNacimiento) {
		String aux=null;
		Integer dia=fechaNacimiento.getDayOfMonth();
		Integer mes=fechaNacimiento.getMonthValue();
		
		if((mes==12 && dia>=21) || mes==1 || mes==2 || (mes==3 && dia<=20)) {
			aux="Verano";
		}
		else {
			if((mes==3 && dia>=21) || mes==4 || mes==5 || (mes==6 && dia<=20)) {
				aux="Otoño";
			}
			else {
				if((mes==6 && dia>=21) || mes==7 || mes==8 || (mes==9 && dia<=20)) {
					aux="Invierno";
				}
				else {
					if((mes==9 && dia>=21) || mes==10 || mes==11 || (mes==12 && dia<=20)) {
						aux="Primavera";
					}
				}
			}
		}
		
		return aux;
	}

}
