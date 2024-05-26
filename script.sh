#!/bin/bash

# Define los nombres de origen y destino
origen="customer"
destino="user"

# Función para convertir mayúsculas/minúsculas manteniendo el caso original
replace_case_sensitive() {
  local input="$1"
  local search="$2"
  local replace="$3"

  local string="${input//$search/$replace}"
  string="${string//"Customer"/"User"}"
  echo "$string"
}

# Función para renombrar archivos y directorios
rename_files_and_dirs() {
  local dir="$1"
  find "$dir" -depth | while read file; do
    # Realiza el reemplazo
    sed -i 's/customer/user/g' "$file"
    sed -i 's/Customer/User/g' "$file"
    sed -i 's/CUSTOMER/USER/g' "$file"

    local base=$(basename "$file")
    local dirpath=$(dirname "$file")
    local newbase=$(replace_case_sensitive "$base" "$origen" "$destino")
    local newfile="$dirpath/$newbase"
    if [ "$file" != "$newfile" ]; then
      mv "$file" "$newfile"
    fi
  done
}

# Directorio inicial (puedes cambiar esto a cualquier directorio que desees)
initial_directory="user"

# Ejecuta la función
rename_files_and_dirs "$initial_directory"

echo "Renombrado completado."
