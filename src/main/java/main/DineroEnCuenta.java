package main;
//TIENE LO QUE DICE EL DIAGRAMA DE CLASES

import javax.persistence.Entity;

@Entity(name = "dineroencuenta")
public class DineroEnCuenta extends MedioDePago {
		double saldo; 
		
		public DineroEnCuenta(double saldo) {
			this.saldo = saldo;
		}
		
		public double getSaldo() {
			return saldo;
		}
		public void setSaldo(double saldo) {
			this.saldo = saldo;
		}



}
