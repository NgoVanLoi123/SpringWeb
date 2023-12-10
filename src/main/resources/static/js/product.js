$(document).ready(function(){
$(".create-product-btn").click(function(){
$("#product-creation-modal").modal("show");
});
    $("#save-product-btn").click(function () {

          var nameValue = $('#name').val();
          var priceValue = $('#price').val();
          var descriptionValue = $('#description').val();
          var imageValue = $('#image').val();
         var formData = new FormData($("#create-product-form")[0]);
            // call api lên backend
            $.ajax({
                type: "POST",
                enctype:"multipart/form-data",
                url: "/admin",
                data: formData,
                contentType: false,
                processData:false,
                success: function (data) {
                    toastr.success("Create a new product successfully");
                    setTimeout(() => {
                        location.reload();
                    }, 1000);
                },
                error: function (err) {
                    console.log(err);
                    toastr.warning("Đã có lỗi xảy ra, vui lòng thử lại");
                }
            });

        });




});

