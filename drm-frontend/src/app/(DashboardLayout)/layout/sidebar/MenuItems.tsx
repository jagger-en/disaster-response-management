import {
  IconAperture,
  IconCopy,
  IconLayoutDashboard,
  IconLogin,
  IconNews,
  IconUserPlus,
} from "@tabler/icons-react";

import { uniqueId } from "lodash";

const Menuitems = [
  {
    navlabel: true,
    subheader: "Auth",
  },
  {
    id: uniqueId(),
    title: "Login",
    icon: IconLogin,
    href: "/authentication/login",
  },
  {
    id: uniqueId(),
    title: "Register",
    icon: IconUserPlus,
    href: "/authentication/register",
  },
  {
    navlabel: true,
    subheader: "Views",
  },
  {
    id: uniqueId(),
    title: "Briefing",
    icon: IconNews,
    href: "/briefing",
  },
  {
    id: uniqueId(),
    title: "Dashboard",
    icon: IconLayoutDashboard,
    href: "/",
  },
  {
    id: uniqueId(),
    title: "Missions",
    icon: IconAperture,
    href: "/missions",
  },
  {
    id: uniqueId(),
    title: "Staff",
    icon: IconAperture,
    href: "/staff",
  },
];

export default Menuitems;
