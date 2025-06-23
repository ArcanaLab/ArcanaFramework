#!/bin/bash

# Crear directorios base
mkdir -p ui/{core,card,table,menu/item,deck,playerhand}

# Archivos core de UI
touch ui/core/UIElement.java
touch ui/core/UIButton.java
touch ui/core/UIText.java
touch ui/core/UILayout.java

# Archivos UI específicos por feature
touch ui/card/CardUI.java
touch ui/table/TableUI.java
touch ui/menu/MenuUI.java
touch ui/menu/item/MenuItemUI.java
touch ui/deck/DeckUI.java
touch ui/playerhand/PlayerHandUI.java
