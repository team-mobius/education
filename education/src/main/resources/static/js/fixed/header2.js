console.log("연결");

const openLoginModal = () => {
  document.querySelector(".login-modal").classList.remove("login-hidden");
};

const closeLoginModal = () => {
  document.querySelector(".login-modal").classList.add("login-hidden");
};

document.querySelector(".open-login-modal").addEventListener("click", openLoginModal);
document.querySelector(".modal-close").addEventListener("click", closeLoginModal);
document.querySelector(".bg").addEventListener("click", closeLoginModal);

console.log("연결");
$(document).ready(function () {
  $("div.tabs div").click(function () {
    var tab_id = $(this).attr("data-tab");

    $("div.tabs div").removeClass("current");
    $(".tab-content").removeClass("current");

    $(this).addClass("current");
    $("#" + tab_id).addClass("current");
  });
});


// review
console.info("연결");
$("a.review").on("click", function(e){
  e.preventDefault();
  location.href = "/review/review";
});
