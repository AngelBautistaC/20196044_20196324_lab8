/*SE CREA LA COLUMNA MEGUSTA, DONDE MEGUSTA=1 -> ME GUSTA Y MEGUSTA=0 ->NADA*/
ALTER TABLE cancion ADD me_gusta TINYINT(4);
UPDATE cancion set me_gusta=0;
