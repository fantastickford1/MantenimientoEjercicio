$(document).ready(function() {
  $('.titulo').click( titleClick );
});

function titleClick( event ){

        var nombre = event.currentTarget.id;

       $.ajax({
           method:'get',
           url   :'ordenarListaPor.do',
           data  :{
               nombre: nombre
           },
           success:function(res){

               console.log(res);
               $('#contentTable').empty();
               $('#contentTable').append( res );

           },
           error  :function (err){
               console.error(err);
           }
       })

}
