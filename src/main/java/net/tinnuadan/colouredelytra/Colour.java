package net.tinnuadan.colouredelytra;

import org.bukkit.Material;

public enum Colour
{
  None(0),
  Black(1),
  Blue(2),
  Brown(3),
  Cyan(4),
  Gray(5),
  Green(6),
  LightBlue(7),
  LightGray(8),
  Lime(9),
  Magenta(10),
  Orange(11),
  Pink(12),
  Purple(13),
  Red(14),
  White(15),
  Yellow(16);

  private final int colourCode;

  Colour(int colourCode)
  {
    this.colourCode = colourCode;
  }

  Material getDye()
  {
    switch (this) {
      case Black: return Material.BLACK_DYE;
      case Red: return Material.RED_DYE;
      case Green: return Material.GREEN_DYE;
      case Brown: return Material.BROWN_DYE;
      case Blue: return Material.BLUE_DYE;
      case Purple: return Material.PURPLE_DYE;
      case Cyan: return Material.CYAN_DYE;
      case LightGray: return Material.LIGHT_GRAY_DYE;
      case Gray: return Material.GRAY_DYE;
      case Pink: return Material.PINK_DYE;
      case Lime: return Material.LIME_DYE;
      case Yellow: return Material.YELLOW_DYE;
      case LightBlue: return Material.LIGHT_BLUE_DYE;
      case Magenta: return Material.MAGENTA_DYE;
      case Orange: return Material.ORANGE_DYE;
      case White: return Material.WHITE_DYE;

      case None:
      default: break;
    }
    return Material.WATER;
  }

  int getCustemModelData()
  {
    return 812800 + colourCode;
  }

/*
Black Dye	black_dye
 Red Dye	red_dye
 Green Dye	green_dye
 Brown Dye	brown_dye
 Blue Dye	blue_dye
 Purple Dye	purple_dye
 Cyan Dye	cyan_dye
 Light Gray Dye	light_gray_dye
 Gray Dye	gray_dye
 Pink Dye	pink_dye
 Lime Dye	lime_dye
 Yellow Dye	yellow_dye
 Light Blue Dye	light_blue_dye
 Magenta Dye	magenta_dye
 Orange Dye	orange_dye
 White Dye	white_dye
 */
}
