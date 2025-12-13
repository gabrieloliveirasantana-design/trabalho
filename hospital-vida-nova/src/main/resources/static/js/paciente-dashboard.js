// ===== Dropdown perfil =====
const profileIcon = document.getElementById('profileIcon');
const profileDropdown = document.getElementById('profileDropdown');

profileIcon.addEventListener('click', () => {
  profileDropdown.classList.toggle('show');
});

window.addEventListener('click', (e) => {
  if (!e.target.closest('.profile-menu')) {
    profileDropdown.classList.remove('show');
  }
});

// ===== Navegação lateral =====
const menuItems = document.querySelectorAll('.menu-item');
const sections = document.querySelectorAll('.section');

menuItems.forEach(item => {
  item.addEventListener('click', () => {
    const id = item.getAttribute('data-section');

    sections.forEach(s => s.classList.remove('active'));
    document.getElementById(id).classList.add('active');

    menuItems.forEach(m => m.classList.remove('active'));
    item.classList.add('active');
  });
});

// ===== Home =====
document.getElementById('homeLink').addEventListener('click', () => {
  sections.forEach(s => s.classList.remove('active'));
  document.getElementById('inicio').classList.add('active');
  menuItems.forEach(m => m.classList.remove('active'));
});

