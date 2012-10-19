package week4

trait Expr {
	def eval: Int = this match {
	  case Number(n) => n
	  case Sum(e1, e2) => e1.eval + e2.eval
	  case Prod(e1, e2) => e1.eval * e2.eval
	}
	
	def show: String = this match {
	  case Number(n) => n.toString
	  case Var(v) => v
	  case Sum(l, r) => 
	    l.show + " + " + r.show
	  case Prod(l, r) => 
	    l.parenthesis + " * " + r.parenthesis
	}
	
	def parenthesis: String = this match {
	  case Number(n) => n.toString
	  case Var(v) => v
	  case Sum(l, r) => "(" + l.show + " + " + r.show + ")"
	  case Prod(l, r) => l.parenthesis + " * " + r.parenthesis
	}
}

case class Sum(e1: Expr, e2: Expr) extends Expr 

case class Prod(e1: Expr, e2: Expr) extends Expr 

case class Number(n: Int) extends Expr 

case class Var(v: String) extends Expr 

//def eval(e: Expr): Int = match {
//  case Number(n) => n
//  case Sum(e1, e2) => eval(e1) + eval(e2)
//}