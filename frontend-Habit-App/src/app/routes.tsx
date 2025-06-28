import InicioSesión from "../ui/pages/InicioSesion";
import TipoCuenta from "../ui/pages/TipoCuenta";

export let enrutador = [
  {
    path: "/",
    element:<InicioSesión/>
  },
  {
    path: "/Roles",
    element:<TipoCuenta/>
  }
]