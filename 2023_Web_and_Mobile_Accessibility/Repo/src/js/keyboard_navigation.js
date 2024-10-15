document.addEventListener("DOMContentLoaded", function () {
  const dropdownMenus = document.querySelectorAll(".dropdown-menu");

  const hideAllDropdowns = () => {
    dropdownMenus.forEach((menu) => {
      menu.classList.remove("show");
    });
  };

  const closeDropdownOnEsc = (e) => {
    if (e.key === "Escape") {
      hideAllDropdowns();
    }
  };

  document.addEventListener("keydown", closeDropdownOnEsc);

  const dropdownToggleButtons = document.querySelectorAll(".dropdown-toggle");

  dropdownToggleButtons.forEach((toggle) => {
    toggle.addEventListener("click", (e) => {
      const parent = e.target.parentNode;
      const dropdownMenu = parent.querySelector(".dropdown-menu");

      hideAllDropdowns();

      if (!dropdownMenu.classList.contains("show")) {
        dropdownMenu.classList.add("show");
      }
    });

    toggle.addEventListener("keydown", (e) => {
      if (e.key === " " || e.key === "Enter") {
        e.preventDefault();
        const parent = e.target.parentNode;
        const dropdownMenu = parent.querySelector(".dropdown-menu");

        hideAllDropdowns();

        if (!dropdownMenu.classList.contains("show")) {
          dropdownMenu.classList.add("show");
        }
      }
    });
  });

  const dropdownLinks = document.querySelectorAll(".dropdown-item");

  dropdownLinks.forEach((link) => {
    link.addEventListener("keydown", (e) => {
      if (e.key === " " || e.key === "Enter") {
        e.preventDefault();
        window.location.href = link.href;
      }
    });
  });

  document.addEventListener("click", (e) => {
    if (!e.target.closest(".dropdown")) {
      hideAllDropdowns();
    }
  });

  const dropdownItems = document.querySelectorAll(".dropdown-item");

  dropdownItems.forEach((item) => {
    item.addEventListener("keydown", (e) => {
      if (e.key === "Tab" && !e.shiftKey) {
        const parentMenu = item.closest('.dropdown-menu');
        const lastItem = parentMenu.querySelectorAll('.dropdown-item');
        if (item === lastItem[lastItem.length - 1]) {
          hideAllDropdowns();
        }
      }
    });
  });
});