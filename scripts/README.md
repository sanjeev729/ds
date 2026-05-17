# Git Commit & Push Automation

This directory contains automation scripts for git operations using SSH authentication.

## Scripts

### `git-commit-push.sh`

A convenient bash script to automate the commit and push workflow using SSH authentication.

#### Features
✓ Uses existing SSH authentication (no password needed)  
✓ Validates repository status  
✓ Stages all changes automatically  
✓ Creates meaningful commits  
✓ Pushes to remote with proper feedback  
✓ Colored output for better readability  

#### Prerequisites
- SSH key configured with GitHub (`~/.ssh/id_ed25519` or similar)
- Public key added to GitHub settings
- Git repository initialized

#### Usage

**Basic usage:**
```bash
./scripts/git-commit-push.sh "Your commit message here"
```

**Example:**
```bash
./scripts/git-commit-push.sh "Optimize performance: reduce O(n²) to O(n log n)"
```

#### What it does
1. Validates you're in a git repository
2. Shows current status
3. Stages all modified/new/deleted files
4. Creates a commit with your message
5. Verifies SSH authentication
6. Pushes changes to GitHub using SSH
7. Displays a summary

#### Output Example
```
📝 Git Commit & Push
==================================
Checking repository status...
On branch main
Nothing to commit, working tree clean
...
✓ Successfully pushed to GitHub!

📊 Summary
==================================
Branch: main
Commit: 754cefe
Message: Optimize performance
Status: Synced with remote
```

#### SSH Authentication Setup

If you haven't configured SSH yet:

1. **Generate SSH key:**
   ```bash
   ssh-keygen -t ed25519 -C "your_email@github.com"
   ```

2. **Add to SSH agent:**
   ```bash
   ssh-add ~/.ssh/id_ed25519
   ```

3. **Get public key:**
   ```bash
   cat ~/.ssh/id_ed25519.pub
   ```

4. **Add to GitHub:**
   - Go to https://github.com/settings/keys
   - Click "New SSH key"
   - Paste your public key
   - Save

5. **Test connection:**
   ```bash
   ssh -T git@github.com
   ```
   You should see: "Hi sanjeev729! You've successfully authenticated..."

#### Common Commit Message Examples

```bash
# Feature development
./scripts/git-commit-push.sh "Add binary search optimization for large datasets"

# Bug fixes
./scripts/git-commit-push.sh "Fix: NullPointerException in LinkedList.reverse()"

# Code quality
./scripts/git-commit-push.sh "Refactor: Extract common logic into utility class"

# Documentation
./scripts/git-commit-push.sh "Docs: Add algorithm complexity analysis"

# Multiple changes
./scripts/git-commit-push.sh "Feat: Add thread pool + refactor queue impl + update docs"
```

#### Troubleshooting

**Problem:** "Permission denied (publickey)"
```bash
# Solution: Verify SSH key is added to agent
ssh-add ~/.ssh/id_ed25519
```

**Problem:** "No changes to commit"
```bash
# You're all synced! Nothing new to commit
```

**Problem:** "Not in a git repository"
```bash
# Solution: Run from project root
cd /Users/sanjeevpal/IdeaProjects/ds
```

#### Aliases (Optional)

Add to your `~/.zshrc` or `~/.bash_profile`:

```bash
alias gcp='~/IdeaProjects/ds/scripts/git-commit-push.sh'
```

Then use:
```bash
gcp "Your commit message"
```

## Related Commands

```bash
# View commit history
git log --oneline -10

# Check current status
git status

# View what will be committed
git diff --cached

# Undo last commit (keep changes)
git reset --soft HEAD~1

# Undo last commit (discard changes)
git reset --hard HEAD~1
```

