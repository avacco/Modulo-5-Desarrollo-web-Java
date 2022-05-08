<script>
$('#sortTable').DataTable({
    language: {
        search: "Buscar:",
        info: "Mostrando registros del _START_ a _END_ de un total de _TOTAL_ registros",
        lengthMenu: "Mostrar _MENU_ registros",
        zeroRecords: "No se encontraron resultados",
        paginate: {
            next: "Siguiente",
            previous: "Anterior"
        }
    }
});
</script>