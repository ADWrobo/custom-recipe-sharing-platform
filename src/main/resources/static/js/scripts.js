document.querySelector('form').addEventListener('submit', function(event) {
    event.preventDefault();
    let searchQuery = document.querySelector('input[name="query"]').value;
    fetch(`/api/recipes/search?query=${encodeURIComponent(searchQuery)}`)
        .then(response => response.json())
        .then(data => {
            let results = document.getElementById('results');
            results.innerHTML = '';
            let ul = document.createElement('ul');
            data.forEach(recipe => {
                let li = document.createElement('li');
                let a = document.createElement('a');
                a.textContent = recipe.name;
                a.href = `/recipe/${recipe.id}`;
                li.appendChild(a);
                ul.appendChild(li);
            });
            results.appendChild(ul);
        })
        .catch(error => console.error('Error:', error));
});
