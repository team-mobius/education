console.log("연결");

const openPasswordModal = () => {
    document.querySelector(".password_change_modal").classList.remove("password_change_hidden");
};

const closePasswordModal = () => {
    document.querySelector(".password_change_modal").classList.add("password_change_hidden");
};

document.querySelector(".open_password_change_modal").addEventListener("click", openPasswordModal);
document.querySelector(".close_password_modal").addEventListener("click", closePasswordModal);
document.querySelector(".bg").addEventListener("click", closePasswordModal);