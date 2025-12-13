// ===== MENU PERFIL =====
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

// ===== SIDEBAR =====
document.querySelectorAll('.menu-item.has-submenu').forEach(item => {
    item.querySelector('.menu-head').addEventListener('click', () => {
        item.classList.toggle('open');
    });
});

// ===== SEÇÕES =====
const sections = document.querySelectorAll('.section');
const submenuItems = document.querySelectorAll('.submenu-item');

submenuItems.forEach(item => {
    item.addEventListener('click', () => {
        const target = item.dataset.section;

        sections.forEach(s => s.classList.remove('active'));
        document.getElementById(target).classList.add('active');

        submenuItems.forEach(i => i.classList.remove('active'));
        item.classList.add('active');
    });
});

// ===== HOME =====
document.getElementById('homeLink').addEventListener('click', () => {
    sections.forEach(s => s.classList.remove('active'));
    document.getElementById('inicio').classList.add('active');
    submenuItems.forEach(i => i.classList.remove('active'));
});

