import Roles from "../ui/components/Roles";
import InicioSesión from "../ui/pages/InicioSesion";

export let enrutador = [
  {
    path: "/",
    element:<InicioSesión/>
  },
  {
    path: "/Roles",
    element:<Roles/>
  }
]