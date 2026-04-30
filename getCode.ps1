# Obtener el nombre de la carpeta donde está el script
$rootFolderName = (Get-Item .).Name
$outputFile = "$rootFolderName.txt"

# Definir la ruta de la carpeta src
$srcPath = Join-Path -Path "." -ChildPath "src"

# Verificar si la carpeta src existe
if (-not (Test-Path $srcPath)) {
    Write-Host "No se encontró la carpeta 'src' en el directorio actual."
    exit
}

# Buscar todos los archivos .java de manera recursiva dentro de src
$javaFiles = Get-ChildItem -Path $srcPath -Filter *.java -Recurse

if ($javaFiles.Count -eq 0) {
    Write-Host "No se encontraron archivos .java dentro de la carpeta src."
    exit
}

# Si ya existe el archivo de salida, lo eliminamos
if (Test-Path $outputFile) {
    Remove-Item $outputFile -Force
}

foreach ($file in $javaFiles) {
    # Obtener la ruta relativa desde la carpeta raíz para el encabezado
    $relativePath = Resolve-Path $file.FullName -Relative
    
    # Escribir el encabezado
    Add-Content -Path $outputFile -Value "// Archivo: $relativePath"
    
    # Escribir el contenido del archivo
    Get-Content $file.FullName | Add-Content -Path $outputFile
    
    # Separador entre archivos
    Add-Content -Path $outputFile -Value "/*------------------------------------------------------------------------------------------*/"
    Add-Content -Path $outputFile -Value ""
}

Write-Host "Archivo '$outputFile' generado con éxito incluyendo $($javaFiles.Count) archivos desde la carpeta src."
